/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Main.LogoManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class GameAdapter {

    List<Integer> cards;
    
    final int CARD_START = 1;
    final int CARD_END = 52;

    double win_amount;
    double total_amount;
    double spend_amount;

    public GameAdapter() {
        cards = new ArrayList<>();
        for (int i = CARD_START; i <= CARD_END; i++) {
            cards.add(i);
        }
        win_amount = 0.00;
        total_amount = 0.00;
        spend_amount = 0.00;
    }

    public List<Integer> randomCards() {
        //shuffle cards multiple times
        for (int i = 0; i < 10; i++) {
            Collections.shuffle(cards);
        }
        return cards.subList(0, 4);
    }

    /**
     * Spin
     */
    public void spin() {
        String amount = GameBoard.getInstance().amount_view.getText().trim();
        if (amount.isEmpty()) {
            AlertMessage.message("Please enter amount !");
            return;
        }
        double inserted_amount = getAmount(amount);
        if (inserted_amount == -1) {
            AlertMessage.message("Please enter amount correctly !");
            return;
        }
        //GameBoard.getInstance().amount_view.setText("");
        //get total spent amount
        spend_amount += inserted_amount;
        List<Integer> random_cards = randomCards();
        //show card images to user
        showCards(random_cards);
        //get duplicated cards number
        int match_number = getDuplicatedTimes(random_cards);
        
        if (match_number > 0) {
            win_amount = inserted_amount * (match_number + 1);
            total_amount += win_amount;
        }
        GameBoard.getInstance().spend_amount.setText(String.valueOf(spend_amount));
        GameBoard.getInstance().win_amount.setText(String.valueOf(win_amount));
        GameBoard.getInstance().total_amount.setText(String.valueOf(total_amount));
    }

    /**
     * show cards on game board
     *
     * @param cards
     */
    private void showCards(List<Integer> cards) {
        GameBoard.getInstance().card_view_1.setImage(LogoManager.getInstance().getCard(cards.get(0)));
        GameBoard.getInstance().card_view_2.setImage(LogoManager.getInstance().getCard(cards.get(1)));
        GameBoard.getInstance().card_view_3.setImage(LogoManager.getInstance().getCard(cards.get(2)));
        GameBoard.getInstance().card_view_4.setImage(LogoManager.getInstance().getCard(cards.get(3)));
    }

    /**
     * Get duplicated card times
     *
     * @param cards
     */
    private int getDuplicatedTimes(List<Integer> cards) {
        List<Integer> card_index_list = new ArrayList();
        for(int item : cards){
            card_index_list.add(item % 13);
        }
        HashSet<Integer> singles = new HashSet<Integer>();
        singles.addAll(card_index_list);
        return card_index_list.size() - singles.size();
    }

    public double getAmount(String num) {
        try {
            double amount = Double.parseDouble(num);
            if (amount <= 0) {
                return -1;
            }
            return amount;
        } catch (Exception e) {
            return -1;
        }
    }
}
