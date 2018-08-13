package SQLTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ����Statement�ӿڵ��÷���ִ��SQL��䣬����SQLע��
 */

public class StatementTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //��������(���Ӷ����ڲ���ʵ������Socket������һ��Զ�̵����ӡ��ȽϺ�ʱ��
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");
            System.out.println(connection);
            statement = connection.createStatement();
            //t_jdbc���������ĸ�����ֵ��id��username��password��regTime������idҪ��Ϊ�Զ�������
            //������t_jdbc���в����У�execute()Ϊ���з�������ִ�������������sql����������Ч

            String sql = "INSERT INTO t_jdbc (username,password,regTime) VALUES ('dd',8888,NOW())";
            statement.execute(sql);

            String sql2 = "INSERT INTO t_jdbc (username,password,regTime) VALUES ('ee',9999,NOW())";
            statement.execute(sql2);

            String sql3 = "delete from t_jdbc where id=3";
            statement.execute(sql3);

            //����SQLע�룬����ֻ��ɾ��t_jdbc����idΪ4���У��������й���ȫ��ɾ���ˣ�������쳣
            String str = "4 or 1=1";
            String sql4 = "delete from t_jdbc where id=" + str;
            statement.execute(sql4);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {//���򿪵Ĺر�
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
