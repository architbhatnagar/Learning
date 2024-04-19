package practice.LowLevelDesign.DesignATM.ATMStates;

import practice.LowLevelDesign.DesignATM.ATM;
import practice.LowLevelDesign.DesignATM.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}
