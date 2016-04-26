package org.wucalv.quickstart.fullrecon.model;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public interface TransactionEffect {

    double NO_IMPACT = 0.0;

    default double affectsUnits(Transaction transaction) {
        return transaction.getUnits();
    }

    default double affectsCapital(Transaction transaction) {
        return transaction.getAmount();
    }

    class DepositEffect implements TransactionEffect {}

    class WithdrawEffect extends DepositEffect {
        @Override
        public double affectsUnits(Transaction transaction) {
            return super.affectsUnits(transaction) * -1;
        }

        @Override
        public double affectsCapital(Transaction transaction) {
            return super.affectsCapital(transaction) * -1;
        }
    }

    class BuyEffect extends DepositEffect {
        @Override
        public double affectsCapital(Transaction transaction) {
            return super.affectsCapital(transaction) * -1;
        }
    }

    class SellEffect extends DepositEffect {
        @Override
        public double affectsUnits(Transaction transaction) {
            return super.affectsUnits(transaction) * -1;
        }
    }

    class DividendReinvestEffect extends DepositEffect {
        @Override
        public double affectsCapital(Transaction transaction) {
            return NO_IMPACT;
        }
    }

    class StockDividendEffect extends DepositEffect {
        @Override
        public double affectsUnits(Transaction transaction) {
            return NO_IMPACT;
        }
    }
 }
