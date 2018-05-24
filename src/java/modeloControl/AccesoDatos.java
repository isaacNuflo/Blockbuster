package modeloControl;

import java.sql.Connection;
import entidades.Category;
import entidades.Film;
import entidades.Inventory;
import entidades.Payment;
import entidades.Rental;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatos {

    private Connection _connection;

    public AccesoDatos() {
        _connection = ConexionSingleton.getConexion("sakila", "localhost", "root", "");
    }

    public List<Category> getCategorias() {
        List<Category> lista = new ArrayList<Category>();

        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = _connection.createStatement();
            String sql = "SELECT NAME FROM CATEGORY";

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Category category = new Category(resultSet.getInt("category_id"), resultSet.getString("name"));
                lista.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Film> getFilmsByCategory(Category category, Integer store_id) {
        List<Film> lista = new ArrayList<Film>();

        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = _connection.createStatement();
            String sql = "SELECT F.FILM_ID,TITLE,"
                    + " DESCRIPTION,"
                    + " RELEASE_YEAR,"
                    + "NAME,"
                    + "RENTAL_DURATION,"
                    + "LENGTH,RATING,"
                    + "REPLACEMENT_COST AS COSTO_REEMPLAZO,"
                    + "RENTAL_RATE AS PRECIO,"
                    + "COUNT(F.film_id) AS DISPONIBLE,"
                    + ",SPECIAL_FEATURES "
                    + "FROM sakila.film_category AS FC INNER JOIN sakila.film AS F ON (FC.film_id=F.film_id) "
                    + "INNER JOIN sakila.language as L ON (F.language_id=L.language_id) "
                    + "INNER JOIN sakila.inventory as I ON (F.film_id=I.film_id) "
                    + "WHERE category_id=" + category.getId() + " "
                    + "and store_id=" + store_id + " "
                    + "group by F.film_id;";

            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Film film = new Film(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getDouble(9), rs.getDouble(10), rs.getInt(11), rs.getString(12));
                lista.add(film);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Inventory> getInventoryByFilm(Film film, Integer store_id) {
        List<Inventory> lista = new ArrayList<Inventory>();

        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = _connection.createStatement();
            String sql = "SELECT I.inventory_id "
                    + "FROM sakila.inventory AS I "
                    + "inner join sakila.film AS F "
                    + "on (I.film_id=F.film_id) "
                    + "where F.film_id=" + film.getId() + "and I.store_id=" + store_id + ";";

            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Inventory inventory = new Inventory(film, rs.getInt(1));
                lista.add(inventory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public void insertRental(Rental rental){
        Statement statement = null;
        try {
            statement = _connection.createStatement();
            java.util.Date javaDate = new java.util.Date();
            long javaTime = javaDate.getTime();
            Timestamp date = new Timestamp(javaTime);
            String sql = "INSERT INTO sakila.payment(rental_id,rental_date,inventory_id,customer_id,return_date,staff_id,last_update) "
                    + "VALUES ("
                    + rental.getId() + ",'"
                    + rental.getRental_date() + "',"
                    + rental.getInventory().getId() + ","
                    + rental.getCustomer_id() + ",'"
                    + rental.getReturn_date() + "',"
                    + rental.getStaff_id() + ",'"
                    + rental.getLast_update() + "'"
                    + ")";

            statement.executeUpdate(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertPayment(Payment payment) {
        Statement statement = null;
        try {
            statement = _connection.createStatement();
            
            String sql = "INSERT INTO sakila.payment(payment_id,customer_id,staff_id,rental_id,amount,payment_date,last_update) "
                    + "VALUES ("
                    + payment.getId() + ","
                    + payment.getRental().getCustomer_id() + ","
                    + payment.getRental().getStaff_id() + ","
                    + payment.getRental().getId() + ","
                    + payment.getAmount() + ",'"
                    + payment.getPayment_date() + "','"
                    + payment.getLast_update() + "'"
                    + ")";

            statement.executeUpdate(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
