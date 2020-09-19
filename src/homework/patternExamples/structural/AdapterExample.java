package homework.patternExamples.structural;

public class AdapterExample {
    public static void main(String[] args) {
        //1-й брокер покупает и продает активы
        StockExchange brokerFirstFirm = new BrokerFirstFirm();
        brokerFirstFirm.buyBonds();
        brokerFirstFirm.buyShares();
        brokerFirstFirm.sellShares();
        brokerFirstFirm.buyCurrency();
        brokerFirstFirm.sellBonds();
        brokerFirstFirm.sellCurrency();
        //2-й брокер покупает и продает активы
        StockExchange brokerSecondFirm = new BrokerSecondFirm(new Human());
        brokerSecondFirm.buyCurrency();
        brokerSecondFirm.sellCurrency();
        brokerSecondFirm.buyShares();
        brokerSecondFirm.buyBonds();
        brokerSecondFirm.sellShares();
        brokerSecondFirm.sellBonds();
    }
}

interface StockExchange {
    void buyShares();

    void sellShares();

    void buyBonds();

    void sellBonds();

    void buyCurrency();

    void sellCurrency();

}

class Human {
    void humanBuyShares() {
        System.out.println("Купить акции");
    }

    void humanSellShares() {
        System.out.println("Продать акции");
    }

    void humanBuyBonds() {
        System.out.println("Купить облигации");
    }

    void humanSellBonds() {
        System.out.println("Продать облигации");
    }

    void humanBuyCurrency() {
        System.out.println("Купить валюту");
    }

    void humanSellCurrency() {
        System.out.println("Продать валюту");
    }
}

class BrokerFirstFirm extends Human implements StockExchange {

    @Override
    public void buyShares() {
        humanBuyShares();
    }

    @Override
    public void sellShares() {
        humanSellShares();
    }

    @Override
    public void buyBonds() {
        humanBuyBonds();
    }

    @Override
    public void sellBonds() {
        humanSellBonds();
    }

    @Override
    public void buyCurrency() {
        humanBuyCurrency();
    }

    @Override
    public void sellCurrency() {
        humanSellCurrency();
    }
}

class BrokerSecondFirm implements StockExchange {
    Human human = null;

    BrokerSecondFirm(Human human) {
        super();
        this.human = human;
    }

    @Override
    public void buyShares() {
        human.humanBuyShares();
    }

    @Override
    public void sellShares() {
        human.humanSellShares();
    }

    @Override
    public void buyBonds() {
        human.humanBuyBonds();
    }

    @Override
    public void sellBonds() {
        human.humanSellBonds();
    }

    @Override
    public void buyCurrency() {
        human.humanBuyCurrency();
    }

    @Override
    public void sellCurrency() {
        human.humanSellCurrency();
    }
}