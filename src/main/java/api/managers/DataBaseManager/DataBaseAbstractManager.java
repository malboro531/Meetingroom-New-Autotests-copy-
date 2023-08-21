package api.managers.DataBaseManager;

import api.managers.DataBaseManager.util.ResultSetParser;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class DataBaseAbstractManager<E> extends DataBaseConnectionManager {

    //ResultSet resultSet = getResultSet();
    Logger logger = getLogger();
    List<String> allIds = getAllIds();

    public abstract List<String> getAll();

    public E getById(String sqlSelectExpression, String id) {
        resultSet = executeQuery(String.format(sqlSelectExpression, id));
        try {
            if (resultSet.next()) {
                return extractFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException("Object in Data Base is not found by ID: " + id);
    }

    public abstract void update(E entity);

    public void delete() {
        throw new NotImplementedException("Method implementation not defined");
    }

    public void deleteFromDataBaseById(String sqlSelectExpression, String id) {
        executeUpdate(String.format(sqlSelectExpression, id));
    }

    public abstract void create(E entity);

    public abstract E extractFromResultSet(ResultSet resultSet) throws SQLException;

    public static <T> T getInfoFromDB(String sqlSelectExpression, Class<T> clazz) {
        return ResultSetParser.castToObject(sqlSelectExpression, clazz);
    }

    public static <T> List<T> getListInfoFromDB(String sqlSelectExpression, Class<T> clazz) {
        return ResultSetParser.castToListObjects(sqlSelectExpression, clazz);
    }

    public abstract int getMaxId();
}
