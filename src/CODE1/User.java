package CODE1;

public class User {
    private String name;
    private String companyName;
    private int yearofJoining;
    private String email;
    private String password;

    public User(String name, String companyName, int yearofJoining) {
        this.name = name;
        this.companyName = companyName;
        this.yearofJoining = yearofJoining;
        this.email = createUserEmail();
        this.password = createUserPassword();
    }

    private String createUserPassword() {
        StringBuilder sb = new StringBuilder();
        sb.append(generateRandomCharacter());
        for (int i = 0; i < 4; i++) {
            sb.append(generateRandomIntegerFromLimit(10));
        }
        sb.append(getfirst5CharactersFromUserName());
        sb.append(generateRandomSpecialSymbol());
        return sb.toString();
    }

    private String createUserEmail() {
        return String.format("%s_%d@%s.com",
                getName().toLowerCase(), getYearofJoining(), getCompanyName().toLowerCase());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getYearofJoining() {
        return yearofJoining;
    }

    public void setYearofJoining(int yearofJoining) {
        this.yearofJoining = yearofJoining;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String getfirst5CharactersFromUserName() {
        if (getName().length() < 5) {
            int difference = 5 - getName().length();
            StringBuilder tempName = new StringBuilder(getName());
            for (int i = 0; i < difference; i++) {
                tempName.append("0");
            }
            return tempName.toString();
        } else {
            return getName().substring(0, 5);
        }
    }

    private char generateRandomSpecialSymbol() {
        char[] specialSymbols =
                {
                        '!', '@', '#', '%', '^', '$', '&', '*',
                        '(', ')', '<', '>', ',', '.', '?', '/',
                        '\\', '|', '[', ']', '\\', '\'', '\"', ';'
                };
        int randomInteger = generateRandomIntegerFromLimit(specialSymbols.length);
        return specialSymbols[randomInteger];
    }

    private char generateRandomCharacter() {
        int randomNumberUpto26 = generateRandomIntegerFromLimit(26);
        return (char) ('a' + randomNumberUpto26);
    }

    public int generateRandomIntegerFromLimit(int limit) {
        return (int) (Math.random() * limit);
    }
}

class UserEntry {
    public static void main(String[] args) {
        User obj = new User("Priyanshu", "google", 2022);
        System.out.println(obj.getEmail());
        System.out.println(obj.getPassword());
    }
}
