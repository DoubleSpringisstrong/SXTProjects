package SQLTest;

import java.sql.*;

/**
 * ����ResultSet
 */
public class ResultSetTest {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");

            String sql = "select id,username,password from t_jdbc where id>?";//ռλ��������ѡȡid����?

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, 2);//���ô�t_jdbc��ѡȡidֵ����2��id��username��password

            /**
             * ������execute()ִ��sql������,���ڸ�ΪexecuteQuery(),���ؽ����ResultSet
             * ͨ��ResultSetѡ����������������t_jdbc���е��У���ͨ��
             */
//            preparedStatement.execute();
            resultSet = preparedStatement.executeQuery();//���ؽ����ResultSet

            while (resultSet.next()) {//�˷�������Ϊbooleanֵ�����������صķ��������Ľ�������Ƿ�����һ��Ԫ��
                /**
                 * getInt(1)����ȡ��һ�е�intֵ,��id
                 * getString(2)����ȡ�ڶ��е�Stringֵ,��username
                 * getString(3)����ȡ�����е�Stringֵ����password
                 */
                System.out.println(resultSet.getInt(1) + "----" + resultSet.getString(2) + "----" + resultSet.getString(3));
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {   //�ֱ�ر�resultSet��preparedStatement��connection
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


