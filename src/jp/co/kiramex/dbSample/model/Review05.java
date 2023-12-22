package jp.co.kiramex.dbSample.model;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.InputStreamReader;
import java.io.IOException;

public class Review05 {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        Connection con = null;
        PreparedStatement spstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/kadaidb?useSSL=false&allowPublicKeyRetrieval=true",
            "root", "Uesugiyozan84");

            String sql = "SELECT * FROM person where id = ?";
            spstmt = con.prepareStatement(sql);

            System.out.print("検索キーワードを入力してください > ");
            String str1 = keyIn();
            int id = Integer.parseInt(str1);

            spstmt.setInt(1,id);
            rs = spstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(name);
                System.out.println(age);
            }
        } catch (ClassNotFoundException e) {
            // TODO 自動生成された catch ブロック
            System.err.println("JDBCドライバのロードに失敗しました。");
            e.printStackTrace();

        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            System.err.println("データベースに異常が発生しました。");
            e.printStackTrace();

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.err.println("ResultSetを閉じるときにエラーが発生しました。");
                    e.printStackTrace();
                }
            }
            if (spstmt != null) { // ← 修正
                try {
                    spstmt.close(); // ← 修正
                } catch (SQLException e) {
                    System.err.println("PreparedStatementを閉じるときにエラーが発生しました。"); // ← 修正
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("データベース切断時にエラーが発生しました。");
                    e.printStackTrace();
                }
            }
        }
    }

    private static String keyIn() {
        String line = null;
        try {
            BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
            line = key.readLine();
        } catch (IOException e) {
        }
        return line;
    }

}