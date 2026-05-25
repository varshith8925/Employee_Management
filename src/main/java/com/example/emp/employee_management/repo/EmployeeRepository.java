package com.example.emp.employee_management.repo;
import com.example.emp.employee_management.model.Employee;
import com.sun.source.tree.BreakTree;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class EmployeeRepository {
    @Autowired
     private JdbcTemplate jdbc;

    public void addEmployee(Employee e) {
        String sql="insert into employee values(?,?,?,?)";
        jdbc.update(sql,e.getId(),e.getName(),e.getRole(),e.getSalary());
        System.out.println("Inserted the record");
    }

    public Employee getEmployee(int id) {
        String sql="select * from employee where id=?";
        RowMapper<Employee> rm=new RowMapper() {
            @Override
            public  Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee e=new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setRole(rs.getString(3));
                e.setSalary(rs.getDouble(4));
                return e;
            }

        };
        return jdbc.queryForObject(sql,rm,id);
    }

    public List<Employee> getAllEmployee() {
        String sql="select * from employee ";
        RowMapper<Employee> rm=new RowMapper() {
            @Override
            public  Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee e=new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setRole(rs.getString(3));
                e.setSalary(rs.getDouble(4));
                return e;
            }

        };
        return jdbc.query(sql,rm);
    }
    public void updateSalary(int id, double sal) {
        String sql="update employee set salary=? where id=?";
        jdbc.update(sql,sal,id);
        System.out.println("updated the employee :" +id+" salary");
    }
    public void deleteEmployee(int id) {
        String sql="delete from employee where id=?";
        jdbc.update(sql,id);
        System.out.println("deleted  the employee :" +id);
    }
}
