public class ConverterApplication {
    public static void main(String[] args) {
        ConverterIf converterIf = new ConverterIf() {

            public String convertMonth(int monthNumber) {
                if (monthNumber == 1) {
                    return ("January");
                } else if (monthNumber == 2) {
                    return ("February");
                } else if (monthNumber == 3) {
                    return ("March");
                } else if (monthNumber == 4) {
                    return ("April");
                } else if (monthNumber == 5) {
                    return ("May");
                } else if (monthNumber == 6) {
                    return ("June");
                } else if (monthNumber == 7) {
                    return ("July");
                } else if (monthNumber == 8) {
                    return ("August");
                } else if (monthNumber == 9) {
                    return ("September");
                } else if (monthNumber == 10) {
                    return ("October");
                } else if (monthNumber == 11) {
                    return ("November");
                } else if (monthNumber == 12) {
                    return ("December");
                } else {
                    return ("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
                }
            }


            public String convertDay(int dayNumber) {
                if (dayNumber == 1) {
                    return ("Sunday");
                } else if (dayNumber == 2) {
                    return ("Monday");
                } else if (dayNumber == 3) {
                    return ("Tuesday");
                } else if (dayNumber == 4) {
                    return ("Wednesday");
                } else if (dayNumber == 5) {
                    return ("Thursday");
                } else if (dayNumber == 6) {
                    return ("Friday");
                } else if (dayNumber == 7) {
                    return ("Saturday");
                } else {
                    return ("You have entered an invalid number, try again.");
                }
            }

        };
        ConverterSwitch converterSwitch = new ConverterSwitch() {

            public String convertMonth(int monthNumber) {
                switch (monthNumber) {
                    case 1:
                        return ("January");

                    case 2:
                        return ("February");

                    case 3:
                        return ("March");

                    case 4:
                        return ("April");

                    case 5:
                        return ("May");

                    case 6:
                        return ("June");

                    case 7:
                        return ("July");

                    case 8:
                        return ("August");

                    case 9:
                        return ("September");

                    case 10:
                        return ("October");

                    case 11:
                        return ("November");

                    case 12:
                        return ("December");

                    default:
                        return ("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
                }
            }

            public String convertDay(int dayNumber) {
                switch (dayNumber) {
                    case 1:
                        return ("Sunday");

                    case 2:
                        return ("Monday");

                    case 3:
                        return ("Tuesday");

                    case 4:
                        return ("Wednesday");

                    case 5:
                        return ("Thursday");

                    case 6:
                        return ("Friday");

                    case 7:
                        return ("Saturday");

                    default:
                        return ("You have entered an invalid number, try again.");
                }
            }


        };
//        System.out.println(converterIf.convertMonth(9));
//        System.out.println(converterIf.convertDay(7));
//        System.out.println(converterSwitch.convertMonth(3));
//        System.out.println(converterSwitch.convertDay(0));
    }
}