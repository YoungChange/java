class Resource{
    private String name;
    private String sex;
    private boolean flag = true;

    public synchronized void set(String name,String sex){
        if(flag){
            this.name = name;
            this.sex = sex;
            flag = false;
            this.notify();
            try{ this.wait(); }catch(InterruptedException e){}
        }
    }

    public synchronized void out(){
        if(!flag){
            System.out.println(name+"......"+sex);
            flag = true;
            this.notify();
            try{ this.wait(); }catch(InterruptedException e){}
        }
    }
}

class Input implements Runnable{
    private Resource r;
    private int i;

    Input(Resource r){
        this.r = r;
        i = 0;
    }
    public void run(){
        while(true){
            if(i == 0){
                r.set("mike","man");
            }else{
                r.set("lili.......","nv");
            }
            i = (i + 1) % 2;
        }
    }
}

class Outout implements Runnable{
    Resource r;
    Outout(Resource r){
        this.r = r;
    }

    public void run(){
        while(true){
            r.out();
        }
    }
}
class ThreadMessageDemo{
    public static void main(String[] args){
        Resource r = new Resource();
        Input in = new Input(r);
        Outout out = new Outout(r);

        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        t1.start();
        t2.start();

    }
}
