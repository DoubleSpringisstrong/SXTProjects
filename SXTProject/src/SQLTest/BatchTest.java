package SQLTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ����Batch�������������������һ�β���20000������
 * ���Խ������������ɾ���Ȳ���
 */
public class BatchTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //jdbc:mysql://localhost:3306/testjdbc
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");
            stmt = connection.createStatement();

            connection.setAutoCommit(false);//��Ϊ�ֶ��ύ����
            //���������������һ���ύ
            for (int i = 0; i < 20000; i++) {
                stmt.addBatch("insert into t_jdbc (username,password,regTime) values ('WZC" + i + "',66666,now())");
            }

            stmt.executeBatch();//ִ�����������
            connection.commit();//�ύ����
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
