//def MAVEN_CMD = "mvn clean test -DplatformName=Android -Ddevice=\"${params.DEVICE}\" -Dcucumber.filter.tags=\"${params.TAGS}\"";
def MAVEN_CMD = "mvn clean test -DplatformName=Android -Ddevice=\"${params.DEVICE}\" -Dgroups=API test";

pipeline {
	agent any
	tools {
		maven 'M3'
	}

	stages {
		stage("Preparation") {
			steps{
				script{
					properties([
						parameters([
							choice(name: "OS", description: "Operation System", choices: "Windows\nLinux\nMacOS"),
							choice(name: "Mobile OS", description: "Mobile Operation System", choices: "Android\niOS"),
							choice(name: "DEVICE", description: "Choose device", choices: "Pixel 2_12.0\nPixel 2-11.0"),
							string(name: "EMULATOR_DEVICE", description: "AVD name", defaultValue: "Pixel 4 API 31 2"),
							string(name: "BRANCH", description: "Choose branch", defaultValue: "main"),
							string(name: "TAGS", description: "Choose tags to testing", defaultValue: "")
						])
					])
				}
			}
		}

		stage('GIT') {
			steps {
				script{
					git branch: "${params.BRANCH}", credentialsId: '6c364003-9bb7-42d1-94dc-f84e04d19416', url: 'https://git.astondevs.ru/aston/meetingroom-new/meetingroom-new-autotests.git'
					
				}
			}
		}

		/*stage('Setup AVD') {
			steps {
				script {
				    if ("${params.OS}" == "Windows") {
						bat "start appium -p 4723";
					    bat "adb start-server";
					    bat "start \"\" emulator -avd ${params.EMULATOR_DEVICE}";
					}
					else {
						sh "start appium -p 4723";
					    sh "adb start-server";
					    sh "emulator -avd ${params.EMULATOR_DEVICE}";
					}

				}
				sleep(time: 20, unit: "SECONDS")
			}
		}*/

		stage('Connection') {
			steps {
				script {
				    if ("${params.OS}" == "Windows") {
				        bat "adb -s emulator-5554 wait-for-device shell getprop dev.bootcomplete";
					}
					else {
					    sh "adb -s emulator-5554 wait-for-device shell getprop dev.bootcomplete";
					}
					sleep(time: 5, unit: "SECONDS")
				}
			}
		}

		stage('Test') {
			steps {
				script {
					if ("${params.OS}" == "Windows") {
						bat "${MAVEN_CMD}";
					}
					else {
						sh "${MAVEN_CMD}";
					}
				}
			}
		}
	}
	post ('Reports') {

				always {
				script {
					allure([
						includeProperties: false,
						properties       : [],
						reportBuildPolicy: "ALWAYS",
						results          : [[path: "**/allure-results"]],
						report           : "allure_reports"
						])
				}
			}
	}
}
