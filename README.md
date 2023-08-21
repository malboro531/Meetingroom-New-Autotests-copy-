# MeetingRoom-New-Autotests

## Mobile Automation

Инструкция по организации фреймворка для мобильной автоматизации(Android) с использованием эмуляторов.
Перечень необходимых тулзов:

- IntelliJ Idea
- Android Studio
- Appium Server
- Appium Inspector
- Node.js
- JDK 18

## Шаг 1. Установка Appium и всех необходимых зависимостей.

- Устанавливаем Appium Server для своей ОС: https://appium.io
- Устанавливаем Android Studio -> Подгружаем эмуляторы разных устройств(В Android Studio открываем android virtual device(AVD) и добавляем хотя бы одно любое устройство с последним андроидом)
- Устанавливаем appium-doctor командой: `npm install appium-doctor -g`
- Запускаем appium-doctor командой: `appium-doctor --android` для того, чтобы убедится, что НЕОБХОДИМЫЕ(necessary) зависимости установлены

Быстрая установка ANDROID_HOME, JAVA_HOME для MacOS и Linux 
- Нужно скачать свежие версии android sdk, java jdk.
- Редактировать файл с переменными средами PATH, узнайте, что у вас ( ~/.zprofile или ~/.bash_profile, ~/.bashrc и т.п.).
Пример `nano ~/.bash_profile`. Пути ANDROID_HOME, JAVA_HOME могут отличаться ниже, отредактируйте под себя.
```
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk18.0.2.jdk/Contents/Home
export PATH=$JAVA_HOME/bin:$PATH

export ANDROID_HOME=/Users/$(whoami)/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/platform-tools
```
 После сохранения, чтобы действия вступили в силу.
 `source ~/.bash_profile`.
 Если после этого, appium-doctor все равно не видит, установленные ANDROID_HOME, JAVA_HOME, перезагрузитесь.
- Если все зависимости установлены, двигаемся дальше.
 
### Настройка Appium Server

При запуске Appium Server установить Host:"0.0.0.0", Port:"4723".
При возникновении проблем пропишите пути ANDROID_HOME, JAVA_HOME в edit configurations.

### Настройка Appium Inspector

> Error. Failed to create session. The requested resource could not be found, or a request was received using an HTTP method that is not supported by the mapped resource.

Solution: Add remote path `/wd/hub`.

## Шаг 2. Android

Для того чтобы Appium Inspector имел доступ к приложению с эмулятором, необходимо правильно установить Desired Capabilities. Проще всего подобрать правильные "капабилити" с помощью `Appium Inspector`. Во вкладке Desired Capabilities ввести следующие данные:

- name: **platformName**, value: **Android**
- name: **platformVersion**, value: **версия нашего Android-устройства**
- name: **app**, value: **путь к нашему приложению**
- name: **deviceName**, value: **любое**
- name: **appPackage**, value: **имя Java пакета Android приложения, которое мы хотим запустить**
- name: **appActivity**, value: **имя activities, которое мы открываем**
 
 **Пример:**

{
"platformName": "Android",
"appium:platformVersion": "12.0",
"appium:app": "C:\\app-debug\\app-debug.apk",
"appium:deviceName": "Pixel_2_API_31",
"appium:appPackage": "com.andersenlab.meeting_room.debug",
"appium:appActivity": "com.andersenlab.meeting_room.app.MainActivity"
}

**appPackage** и **appActivity** узнаём следующим образом:
`adb shell pm list packages | grep «app name»`, где app name - название нашего приложения. Таким образом мы получаем значение поля appPackage. Чтобы узнать appActivity для начала откроем приложение на эмуляторе и воспользуемся этой командой `adb shell dumpsys window windows >> Desktop/activity.txt`. Все данные будут отправлены на рабочий стол в документ activity.txt. Открываем этот документ и ищем найденное значение appPackage, рядом с ним будет прописана и appActivity(а-ля ...activities.MainActivity).
Значения получены.
Если значения верны, приложение запускается через Appium и появляется окно со скриншотом приложения, то данные настройки можно переносить в Idea.

Поиск **appPackage** и **appActivity** для MacOS и Linux:
- В Android Studio запустите эмулятор устройства и установите на него apk приложения (просто drag&drop).
- Затем обязательно откройте это приложение, чтобы получить активный фокус
- В терминале `adb shell dumpsys window | grep -E 'mCurrentFocus'` 
- Эта команда даст appActivity активного фокуса экрана эмулятор
- Уберите в конце MainActivity и получите appPackage

## Шаг 3. Запуск теста

1. Настроить `Edit Configurations`: добавить новую конфигурацию: `+` и выбрать`TestNG`:
- `Configuration`: name: **название тестового класса**; class: выбрать нужное в выпадающем меню
- `JDK Settings`: VM options: **-ea -DplatformName=Android или iOS -Ddevice="имя устройства" -Dversion="версия платформы"**;
  **Пример:** -ea -DplatformName="Android" -Ddevice="Pixel_2_API_31" -Dversion="12.0"
- `Working directory`: **$MODULE_WORKING_DIR$**
- `Use classpath of module`: выбрать нужное в выпадающем меню
- `Shorten commandLine`: none

## Postman
Для автотестов нужен будет пользователь. Пример тестового пользователя для входа в приложение необходимо создать в Postman:
- Добавьте в Postman коллекцию *.json из карты проекта.
- Выберите коллекцию, пролистайте вниз, нажмите `Get New Access Token`.
- Вас перенаправит на окно авторизации, ОБЯЗАТЕЛЬНО выберите `Register`.
- В поле Username придумайте логин, он должен соответствовать правилам.
- В поле Email используйте свою почту, которую не жалко, на нее будут приходить коды.
Логин и пароль можно добавлять в код




