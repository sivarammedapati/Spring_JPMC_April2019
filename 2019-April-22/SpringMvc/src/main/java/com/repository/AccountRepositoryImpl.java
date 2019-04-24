package com.repository;

import com.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
//@Transactional
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> fetchAll(){

        return jdbcTemplate.query("select * from account", new RowMapper<Account>() {


            @Override
            public Account mapRow(ResultSet rs, int index) throws SQLException {
                return new Account(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("balance"));
            }
        });

    }

    @Override
    public void save(Account account) throws Exception {

        String sql = "insert into account (id, name, balance) values(?, ?, ?)";
        int rowsAffected
                =  jdbcTemplate.update(sql, account.getId(), account.getName(), account.getBalance());
        if(rowsAffected != 1){
            throw new Exception("Account save failed");
        }
    }
    @Override
    public void update(Account account){}
    @Override
    public void delete(Account account){}

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void deposit(int id, double amt)throws  Exception{

        String sql = "update account set balance = balance + ? where id = ?";
        int rowsAffected = jdbcTemplate.update(sql, amt, id);
        if(rowsAffected != 1){
            throw new Exception("Deposit failed");
        }
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void withdraw(int id, double amt)throws  Exception{

        String sql = "update account set balance = balance - ? where id = ? and balance > ?";
        int rowsAffected = jdbcTemplate.update(sql, amt, id, amt);
        if(rowsAffected != 1){
            throw new Exception("Deposit failed");
        }
    }

    /*public void transfer(int fromId, int toId, double amt) throws Exception {

        try{
            this.deposit(toId, amt);
            this.withdraw(fromId, amt);
        }catch (Exception ex){
            throw  ex;
        }

    }*/
}
