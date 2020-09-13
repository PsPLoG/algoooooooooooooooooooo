package com.company.line;

import java.util.ArrayList;

public class Num5 {
    static int money = 0;
    static ArrayList<Integer> diler = new ArrayList<>();
    static ArrayList<Integer> player = new ArrayList<>();

    public static void addMoney(int add) {
        System.out.println(money + "+" + add);
        money += add;

    }

    public static boolean checkBlackjack(ArrayList<Integer> list) {
        int bigResult = 0;
        int smallResult = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1)
                bigResult += 11;
            else if (list.get(i) >= 10)
                bigResult += 10;
            else
                bigResult += list.get(i);

        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1)
                smallResult += 1;
            else if (list.get(i) >= 10)
                smallResult += 10;
            else
                smallResult += list.get(i);
        }
        if (bigResult == 21 || smallResult == 21)
            return true;
        else
            return false;
    }

    public static int checkScore(ArrayList<Integer> list, boolean big) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (big) {
                if (list.get(i) == 1)
                    result += 11;
                else if (list.get(i) >= 10)
                    result += 10;
                else
                    result += list.get(i);
            } else {
                if (list.get(i) == 1)
                    result += 1;
                else if (list.get(i) >= 10)
                    result += 10;
                else
                    result += list.get(i);
            }
        }
        return result;
    }

    public static int solution(int[] cards) {
        int i = 0;
//            1. 딜러가 카드를 한 장 뽑아 플레이어에게 준다.
//            2. 딜러가 카드를 한 장 뽑아 딜러 앞에 뒤집어 놓는다.
//            3. 딜러가 카드를 한 장 뽑아 플레이어에게 준다.
//            4. 딜러가 카드를 한 장 뽑아 딜러 앞에 보이도록 놓는다.
        while (cards.length > i) {
            diler= new ArrayList<>();
            player= new ArrayList<>();
            System.out.println("시작");
            if (cards.length - i < 3)
                break;
            player.add(cards[i++]);
            diler.add(cards[i++]);
            player.add(cards[i++]);
            diler.add(cards[i++]);
            int openCard = diler.get(1);

            if ((checkScore(player, true) == 21 || checkScore(player, false) == 21)) {
                addMoney(3);
                if ((checkScore(diler, true) == 21 || checkScore(diler, false) == 21)) {
                    addMoney(-3);
                    continue;
                }
                continue;
            }

            if ((checkScore(diler, true) == 21 || checkScore(diler, false) == 21)) {
                addMoney(-2);
                continue;
            }

//            5. 플레이어에게 카드를 더 받을지 말지 물어본다.
//            5.1 플레이어가 최초로 받은 카드 두 장의 합이 21인 경우에는 더 이상 카드를 받지 않고, 딜러의 카드를 확인하여 승패를 결정한다.
            for (; i < cards.length; i++) {
//            1. 딜러의 보이는 카드가 1이거나 7 이상인 경우, 플레이어는 카드 합이 17 이상이 될 때까지 받는다.
//            2. 딜러의 보이는 카드가 4, 5, 6인 경우, 플레이어는 카드를 받지 않는다.
//            3. 딜러의 보이는 카드가 2, 3인 경우, 플레이어는 카드 합이 12 이상이 될 때까지 받는다.
                if (openCard >= 7 || openCard == 1) {
                    player.add(cards[i]);
                    if (checkScore(player, true) >= 17) {
                        break;
                    }
                } else if (openCard == 4 || openCard == 5 || openCard == 6) {
                    break;
                } else if (openCard == 2 || openCard == 3) {
                    player.add(cards[i]);
                    if (checkScore(player, true) >= 12 || checkScore(player, false) >= 12) {
                        break;
                    }
                }
            }
            System.out.println("카드받기끝"+checkScore(player, true));
            if (checkBlackjack(player)) {
                addMoney(2);
                continue;
            }
            if (checkScore(player, false) > 21) {
                addMoney(-2);
                continue;
            }
//            5.3 플레이어가 받은 모든 카드의 합이 21을 넘어가면 플레이어가 즉시 게임에서 진다.
            for (; i < cards.length; i++) {
                if (checkScore(diler, false) >= 17) {
                    if (21 - checkScore(player, false) > 21 - checkScore(diler, false)) {
                        addMoney(-2);
                    } else {
                        addMoney(2);
                    }
                    break;
                }
                diler.add(cards[i]);
                if (checkScore(diler, false) > 21) {
                    addMoney(2);
                    break;
                }
            }

//            6. 플레이어가 더이상 카드를 받지 않으면 딜러 앞의 뒤집어놓은 카드를 공개한 후, 딜러의 카드 합이 17 이상이 될 때까지 계속해서 딜러가 카드를 한 장씩 받는다.
//            6.1 딜러가 받은 모든 카드의 합이 21을 넘으면 딜러가 즉시 게임에서 진다.
//            6.2 이때 딜러는 플레이어가 가진 카드의 합을 고려하지 않으며, 딜러가 가진 카드의 합이 17 이상이 되면 받기를 중단한다.
//            7. 승패를 가린다. 카드 합이 21에 더 가까운 사람이 이기며, 카드 합이 서로 같으면 비긴다.

        }
        return money;
    }

    public static void main(String[] args) {
        int[] cards = {12, 7, 11, 6, 2, 12};
        System.out.println(solution(cards));
    }
}
