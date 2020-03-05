package com.epam.automation.collections.mainTask;

import com.epam.automation.collections.mainTask.candies.*;

import java.util.Scanner;

class ConsoleApp {

       public static NewYearSweetyGift gift = new NewYearSweetyGift( "Roshen");
       static {
           for (int i = 0; i < 5; i++) {
               gift.add(new Lollipop("Bim - Bom", "Roshen", 18.2));
               gift.add(new Lollipop("Bonbonita", "Roshen", 18.5));
               gift.add(new Lollipop("Juice Mix", "Roshen", 18.7));
               gift.add(new ChocolateCandy("Canoy Nut", "Roshen", 20.3));
               gift.add(new ChocolateCandy("Mont Blanc", "Roshen", 21.5));
               gift.add(new ChocolateCandy("Grand Toffy", "Roshen", 19.8));
               gift.add(new ChocolateCandy("Coffee Like", "Roshen", 20.3));
               gift.add(new ChocolateCandy("DeLuxe", "Roshen", 21.5));
               gift.add(new GumGrops("Yumm Gumm", "Roshen", 10.2));
               gift.add(new GumGrops("Crazy Bee", "Roshen", 10.5));
               gift.add(new GumGrops("Crazy Bee", "Roshen", 10.5));
           }
           System.out.println(gift);
       }

           void run() {
               Scanner scanner = new Scanner(System.in);
               int choice;
               do {
                   printMenu();
                   choice =  scanner.nextInt();
                   printTask(choice);
               } while (scanner.hasNextLine());
           }

    private static void printTask(int choice){
        switch (choice){
            case 1:
                gift.getCandies().sort(new ComparatorWeight());
                System.out.println("Сортировки конфет в подарке по весу\n" + gift);
                break;
            case 2:
                gift.getCandies().sort(new ComparatorSugar());
                System.out.println("Сортировки конфет в подарке по содержанию сахара\n" + gift);
                break;
            case 3:
                System.out.println("Вес новогоднего подарка = "+gift.getGiftWeight()+" грамм");
                break;
            case 4:
                gift.candyWithSugar();
                break;
            case 0:
                exit();
            default:
                System.out.println("Неверный ввод");
                break;
        }
    }

    private static void printMenu(){
        String task = "Пожалуйста, сделайте выбор: " + "\n"+
                "Введите 1, для сортировки конфет в подарке по весу"+"\n"+
                "Введите 2, для сортировки конфет в подарке по содержанию сахара"+"\n"+
                "Введите 3, для получения веса новогоднего подарка"+"\n"+
                "Введите 4, для нахождения конфеты в подарке, соответствующая заданному диапазону содержания сахара.)"+"\n"+
                "Введите 0, выхода из программы";
        System.out.println("\n" + task + "\n");
    }

    private static void exit() {
           System.exit(0);
    }
}

