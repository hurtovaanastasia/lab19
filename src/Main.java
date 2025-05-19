enum Size {
    XXS(32) {
        @Override
        public String getDescription() {
            return "Детский размер";
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);

    private int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public String getDescription() {
        return "Взрослый размер";
    }

    public int getEuroSize() {
        return euroSize;
    }
}

interface MenClothing {
    void dressMan();
}

interface WomenClothing {
    void dressWoman();
}

abstract class Clothes {
    private Size size;
    private double price;
    private String color;

    public Clothes(Size size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
}

class TShirt extends Clothes implements MenClothing, WomenClothing {
    public TShirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужская футболка: размер " + getSize() + " (" + getSize().getEuroSize() + "), цвет " + getColor() + ", цена " + getPrice());
    }

    @Override
    public void dressWoman() {
        System.out.println("Женская футболка: размер " + getSize() + " (" + getSize().getEuroSize() + "), цвет " + getColor() + ", цена " + getPrice());
    }
}

class Pants extends Clothes implements MenClothing, WomenClothing {
    public Pants(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужские штаны: размер " + getSize() + " (" + getSize().getEuroSize() + "), цвет " + getColor() + ", цена " + getPrice());
    }

    @Override
    public void dressWoman() {
        System.out.println("Женские штаны: размер " + getSize() + " (" + getSize().getEuroSize() + "), цвет " + getColor() + ", цена " + getPrice());
    }
}

class Skirt extends Clothes implements WomenClothing {
    public Skirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressWoman() {
        System.out.println("Юбка: размер " + getSize() + " (" + getSize().getEuroSize() + "), цвет " + getColor() + ", цена " + getPrice());
    }
}

class Tie extends Clothes implements MenClothing {
    public Tie(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Галстук: размер " + getSize() + " (" + getSize().getEuroSize() + "), цвет " + getColor() + ", цена " + getPrice());
    }
}

class Atelier {
    public void dressWoman(Clothes[] clothes) {
        System.out.println("Женская одежда в ателье:");
        for (Clothes item : clothes) {
            if (item instanceof WomenClothing) {
                ((WomenClothing) item).dressWoman();
            }
        }
    }

    public void dressMan(Clothes[] clothes) {
        System.out.println("Мужская одежда в ателье:");
        for (Clothes item : clothes) {
            if (item instanceof MenClothing) {
                ((MenClothing) item).dressMan();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new TShirt(Size.S, 29.99, "красный"),
                new Pants(Size.M, 59.99, "фиолетовый"),
                new Skirt(Size.XS, 39.99, "черный"),
                new Tie(Size.L, 19.99, "серый")
        };
        Atelier atelier = new Atelier();
        atelier.dressWoman(clothes);
        atelier.dressMan(clothes);
        System.out.println("Описание размеров:");
        for (Size size : Size.values()) {
            System.out.println(size + " (" + size.getEuroSize() + "): " + size.getDescription());
        }
    }
}