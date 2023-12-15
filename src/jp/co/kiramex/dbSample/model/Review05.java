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
        PreparedStatement ipstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/kadaidb?useSSL=false&allowPublicKeyRetrieval=true",
                    "root", "Uesugiyozan84");

            String selectSql = "SELECT * FROM person where id = ?";
            spstmt = con.prepareStatement(selectSql);

            System.out.print("検索キーワードを入力してください > ");
            String str1 = keyIn();

            spstmt.setString(1, str1);

            rs = spstmt.executeQuery();

            System.out.println("更新前===================");

            while (rs.next()) {
                // Name列の値を取得
                int id = rs.getInt("Id");
                // 取得した値を表示
                String name = rs.getString("Name");

                System.out.println("更新処理実行=============");

                // 更新用SQLおよび更新用PreparedStatementオブジェクトを取得
                String insertSql = "INSERT INTO person (Name,Id) VALUES ('Rafah',?,'Rafah',?)";
                ipstmt = con.prepareStatement(insertSql);

                System.out.print("idを数字で入力してください > ");
                int num1 = keyInNum();
                ipstmt.setString(1, str1);
                ipstmt.setInt(2, num1);

                int count = ipstmt.executeUpdate();
                System.out.println("更新行数：" + count);
                rs.close();// 更新後の検索のため、一旦閉じる（閉じないと警告が出るため）
                System.out.println("更新後=================");
                // 検索の再実行と結果を格納／代入
                rs = spstmt.executeQuery();

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
            if (ipstmt != null) { // ← 修正
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

    private static int keyInNum() {
        int result = 0;
        try {
            result = Integer.parseInt(keyIn());
        } catch (NumberFormatException e) {
        }
        return result;
    }
}
