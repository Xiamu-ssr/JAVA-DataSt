package org.kmo.program.P10.t03;

public class DrawThread extends Thread{

    public Account account;
    public DrawThread(Account account) {
        this.account = account;
    }

    public DrawThread(Account account, String name) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        account.drawMoney(100000);
    }
}
