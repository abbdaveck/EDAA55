package memory;

public class test {
    public static void main(String[] args){
        System.out.println("test");
        String back = "C:/Users/david/Documents/LTH/Programmering - EDAA55/pt-workspace/Lab08-memory/back.jpg";
        String[] fronts = {"C:/Users/david/Documents/LTH/Programmering - EDAA55/pt-workspace/Lab08-memory/can.jpg",
        "C:/Users/david/Documents/LTH/Programmering - EDAA55/pt-workspace/Lab08-memory/flopsy_mopsy_cottontail.jpg",
        "C:/Users/david/Documents/LTH/Programmering - EDAA55/pt-workspace/Lab08-memory/friends.jpg",
        "C:/Users/david/Documents/LTH/Programmering - EDAA55/pt-workspace/Lab08-memory/mother_ladybird.jpg",
        "C:/Users/david/Documents/LTH/Programmering - EDAA55/pt-workspace/Lab08-memory/mr_mcgregor.jpg",
        "C:/Users/david/Documents/LTH/Programmering - EDAA55/pt-workspace/Lab08-memory/mrs_rabbit.jpg",
        "C:/Users/david/Documents/LTH/Programmering - EDAA55/pt-workspace/Lab08-memory/mrs_tittlemouse.jpg",
        "C:/Users/david/Documents/LTH/Programmering - EDAA55/pt-workspace/Lab08-memory/radishes.jpg"
    };
        MemoryBoard m = new MemoryBoard(10, back, fronts);
        
    }
}
