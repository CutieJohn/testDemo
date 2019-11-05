package com.john.demo.controller;

import com.john.demo.entity.Account;
import com.john.demo.entity.ResultData;
import com.john.demo.exception.AccountException;
import com.john.demo.exception.CardException;
import com.john.demo.service.AccountService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

@RestController
@RequestMapping("/account")
@Api(tags = "account")
public class AccountController {


    @Autowired
    private AccountService accountService;

    @GetMapping("/retrieveBalance")
    @ApiOperation(value="retrieve balance by account id")
    @ApiImplicitParams({
            @ApiImplicitParam(name="cardNo",value="card number you want to retrieve the balance, you can use mocked card number 2859382746585976123 or 2859382746585976124",dataType="String", paramType = "query")
    })
    @ApiResponse(response = ResultData.class,code = 200, message = "success")
    public Object retrieveBalance(String cardNo) throws Exception {
        Account accout = null;
            accout = accountService.retrieveBalance(cardNo);

        // edit the account information if other information is not needed

        // return account information

        return new ResultData(ResultData.STATUS_SUCCESS,accout);

    }

    @PostMapping("/transaction")
    @ApiOperation(value="make a transaction")
    @ApiImplicitParams({
            @ApiImplicitParam(name="fromCard",value="card number you want to transact from",dataType="String", paramType = "query"),
            @ApiImplicitParam(name="toCard",value="card number you want to transact to",dataType="String", paramType = "query"),
            @ApiImplicitParam(name="money",value="how much you want to make the transaction",dataType="double", paramType = "query")
    })
    public Object transaction(String fromCard, String toCard, double money) throws Exception {
        Account accountFrom = null;
        Account accountTo = null;

        // check the card numbers cannot be the same

        // retrieve balance
        accountFrom = accountService.retrieveBalanceService(fromCard);
        accountTo = accountService.retrieveBalanceService(toCard);

        // make transaction
        accountService.makeTransaction(accountFrom, accountTo, money);

        // retrieve updated balance
        accountFrom = accountService.retrieveBalanceService(fromCard);

        // return account information
        return new ResultData(ResultData.STATUS_SUCCESS,accountFrom);
    }

    @PostMapping("/transactionForTest")
    @ApiOperation(value="make a transaction")
    @ApiImplicitParams({
            @ApiImplicitParam(name="fromCard",value="card number you want to transact from",dataType="String", paramType = "query"),
            @ApiImplicitParam(name="toCard",value="card number you want to transact to",dataType="String", paramType = "query"),
            @ApiImplicitParam(name="money",value="how much you want to make the transaction",dataType="double", paramType = "query")
    })
    @ApiIgnore
    public Object transactionForTest(@RequestBody Map<String, Object> condition) throws Exception {
        Account accountFrom = null;
        Account accountTo = null;

        String fromCard = (String)condition.get("fromCard");
        String toCard = (String)condition.get("toCard");
        Double money = (double) condition.get("money");
        // retrieve balance
        accountFrom = accountService.retrieveBalanceService(fromCard);
        accountTo = accountService.retrieveBalanceService(toCard);

        // make transaction
        accountService.makeTransaction(accountFrom, accountTo, money);

        // retrieve updated balance
        accountFrom = accountService.retrieveBalanceService(fromCard);

        // return account information
        return new ResultData(ResultData.STATUS_SUCCESS,accountFrom);
    }
}
