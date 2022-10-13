package com.bikego.env.management.controller.testCase.part16;

import org.junit.Test;

public class ThreadCommunication {

    /**
     * 线程通信
     *
     * ➢ wait()：导致当前线程等待，直到其他线程调用该同步监视器的notify()方法或notifyAll()方法来唤醒该线程。
     * 该wait()方法有三种形式——无时间参数的wait（一直等待，直到其他线程通知）、带毫秒参数的wait()和带毫秒、毫微秒参数的
     * wait()（这两种方法都是等待指定时间后自动苏醒）。调用wait()方法的当前线程会释放对该同步监视器的锁定。
     * ➢ notify()：唤醒在此同步监视器上等待的单个线程。如果所有线程都在此同步监视器上等待，则会选择唤醒其中一个线程。
     * 选择是任意性的。只有当前线程放弃对该同步监视器的锁定后（使用wait()方法），才可以执行被唤醒的线程。
     * ➢ notifyAll()：唤醒在此同步监视器上等待的所有线程。只有当前线程放弃对该同步监视器的锁定后，才可以执行被唤醒的线程。
     */

    @Test
    public void t0()
    {
        Account account = new Account("my bank account 001 ",0);
        (new DepositThread("存款者甲",account,800)).start();
        (new DrawThread("取款者",account,800)).start();
        new DepositThread("存款者乙",account,800).start();
        new DepositThread("存款者丙",account,800).start();
    }

    /**
     * 对线程组的控制相当于同时控制这批线程。用户创建的所有线程都属于指定线程组，如果程序没有显式指定线程属于哪个线程组，则该线程属于默认线程组。
     */
}

class Account{
    private String accountNo;
    private double balance;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private boolean flag = false;

    public Account(String accountNo,double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public synchronized void draw(double drawAmount) {
        try{
            if (!flag)
            {
                wait();
            }else{
                System.out.println(Thread.currentThread().getName() + " 取钱:"+ drawAmount);
                balance -= drawAmount;
                System.out.println("账户余额为: " + balance);
                flag = false;
                notifyAll();
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount) {
        try{
            if (flag)
            {
                wait();
            }else{
                System.out.println(Thread.currentThread().getName() + " 存钱:"+ depositAmount);
                balance += depositAmount;
                flag = true;
                notifyAll();
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
class DrawThread extends  Thread{
    private Account account;
    private double drawAmount;
    public DrawThread(String name,Account account,double drawAmount)
    {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }
    public void run()
    {
        for(var i = 0;i<100;i++)
        {
                account.draw(drawAmount);
        }

    }
}
class DepositThread extends  Thread{
    private Account account;
    private double depositAmount;
    public DepositThread(String name,Account account,double depositAmount)
    {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }
    public void run()
    {
        for(var i = 0;i<100;i++)
        {
                account.deposit(depositAmount);
        }
    }
}