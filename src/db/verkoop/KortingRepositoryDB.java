package db.verkoop;

import db.BaseRepositoryDB;
import domain.korting.Korting;
import domain.korting.KortingFactory;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class KortingRepositoryDB extends BaseRepositoryDB implements KortingRepository {
    private KortingFactory factory;

    public KortingRepositoryDB(InputStream resourceAsStream) {
        super("kortingen", resourceAsStream);
        factory = new KortingFactory();
    }

    @Override
    public Korting get(String code) {
        try {
            PreparedStatement statement = db.prepareStatement(
                    String.format("SELECT * FROM %s WHERE code = ?", this.getTable())
            );
            statement.setString(1, code);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                return factory.createKorting(result.getString("code"), result.getDouble("amount"), result.getString("type"), result.getInt("productid"));
            }
            throw new IllegalStateException("unknown data from database");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Korting> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(Korting korting) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Korting korting) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(String code) {
        // TODO Auto-generated method stub

    }

}
