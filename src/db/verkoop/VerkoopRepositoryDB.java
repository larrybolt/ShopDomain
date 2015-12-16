package db.verkoop;

import db.BaseRepositoryDB;
import domain.verkoop.Verkoop;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 * 
 * @author Larry & Annelore
 *
 */
public class VerkoopRepositoryDB extends BaseRepositoryDB implements VerkoopRepository {

    public VerkoopRepositoryDB(InputStream resourceAsStream) {
        super("verkopen", resourceAsStream);
        // TODO Auto-generated constructor stub
    }

    public Verkoop get(int id) {
        throw new IllegalArgumentException("not implemented");
    }

    public List<Verkoop> getAll() {
        throw new IllegalArgumentException("not implemented");
    }

    public void add(Verkoop verkoop) {
        if (verkoop == null) {
            throw new IllegalArgumentException("No Verkoop given");
        }
        try {
            PreparedStatement statement = db.prepareStatement(
                    String.format("INSERT INTO %s (id,totaalPrijs ) VALUES (?,?) RETURNING id;", this.getTable())
            );
            statement.setInt(1, this.generateNewId());
            statement.setDouble(2, verkoop.getTotalcost());

            ResultSet result = statement.executeQuery();
            result.next();
            this.last_insert_id = result.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void update(Verkoop verkoop) {
        throw new IllegalArgumentException("not implemented");
    }

    public void delete(int id) {
        try {
            PreparedStatement statement = db.prepareStatement(
                    String.format("DELETE FROM %s WHERE id = ?", this.getTable())
            );
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int generateNewId() {
        return this.last_insert_id + 1;
    }


}
