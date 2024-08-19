class Bank {

    long[] balanceArr;

    public Bank(long[] balance) {
        balanceArr = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (isValidAccount(account1) && isValidAccount(account2)) {
            if (balanceArr[account1 - 1] >= money) {
                balanceArr[account1 - 1] -= money;
                balanceArr[account2 - 1] += money;
                return true;
            } else {
                return false; // Not enough balance to transfer
            }
        } else {
            return false; // Invalid account numbers
        }
    }
    
    public boolean deposit(int account, long money) {
        if (isValidAccount(account)) {
            balanceArr[account - 1] += money;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean withdraw(int account, long money) {
        if (isValidAccount(account)) {
            if (balanceArr[account - 1] >= money) {
                balanceArr[account - 1] -= money;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean isValidAccount(int account) {
        return account >= 1 && account <= balanceArr.length;
    }
}
