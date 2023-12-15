package jp.co.kiramex.dbSample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectSample02 {

    public static void main(String[] args) {
        
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
        try {
            // TODO 自動生成されたメソッド・スタブ
            Class.forName("com.mysql.cj.jdbc.Driver");
      
        con = DriverManager.getConnection (
                "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
                "root",
                "Uesugiyozan84");
        stmt = con.createStatement();
        // 5, 6. Select文の実行と結果を格納／代入
        String sql = "SELECT * FROM country LIMIT 50";
        rs = stmt.executeQuery(sql);
        // 7. 結果を表示する
        while( rs.next() ){
            // Name列の値を取得
            String name = rs.getString("Name");
            // 取得した値を表示
            int population = rs.getInt("population");
                    
            System.out.println(name);
            System.out.println(population); 
        }
        
        }catch (ClassNotFoundException e) {
        System.err.println("JDBCドライバのロードに失敗しました。");
        e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("データベースに異常が発生しました。");
            e.printStackTrace();
        } finally {
            // 8. 接続を閉じる
            if( con != null ){
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("データベース切断時にエラーが発生しました。");
                    e.printStackTrace();
        }
    }}
    }}

