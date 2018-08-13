package SQLTest;

import java.sql.*;

/**
 * ����PreparedStatement���÷�,ִ��sql���
 */
public class PreparedStatementTest {
    public static void main(String[] args) {
        try {
            /**
             * ������
             */
            Class.forName("com.mysql.jdbc.Driver");
            /**
             * ��������
             */
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");

            String str = "insert into t_jdbc (username,password,regTime) values (?,?,?)";//?Ϊռλ�����Ȳ���ֵ�����Ժ����ٸ�ֵ
            /**
             * ���PreparedStatementִ��sql���
             */
            PreparedStatement ps = connection.prepareStatement(str);
//            ps.setString(1,"WZC");//���õ�һ��ռλ�����������Stringֵ
//            ps.setString(2,"123456");//���õڶ���ռλ��?�������Stringֵ

            ps.setObject(1, "LY");//ʹ��setObject()�������Բ���ռλ�������������
            ps.setObject(2, "23456");
            ps.setObject(3, new Date(System.currentTimeMillis()));//�˴���new Date()Ҫ��java.sql.Date()

            ps.execute();//ִ�����


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
