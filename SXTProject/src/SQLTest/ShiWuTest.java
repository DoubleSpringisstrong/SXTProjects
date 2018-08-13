package SQLTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ������������
 */

public class ShiWuTest {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement2 = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");

            connection.setAutoCommit(false);//��������Ϊ�ֶ��ύ����jdbc��Ĭ��Ϊtrue���Զ��ύ����
            /**
             * ����������������ͬ��һ������Ҫôͬʱִ�гɹ���Ҫôͬʱִ��ʧ��
             * ���ĳһ��ִ��ʧ�ܣ��ǲ���ı�ͻع��������״̬
             */

            String sql = "insert into t_jdbc (username,password) values(?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, "WZC");
            preparedStatement.setObject(2, "123456");
            preparedStatement.execute();

            String sql2 = "insert into t_jdbc (username,password) values(?,?)";
            preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setObject(1, "����");
            preparedStatement2.setObject(2, "123456");
            preparedStatement2.execute();

            connection.commit();//�ύ����

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();

            /**
             * �ع����������쳣ʱ�������ݱ��״̬��Ϊ�����״̬
             */
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
