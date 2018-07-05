package com.zhihuishu.basic.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/2.
 */
public class TalkingClock {
    private int interval;
    private boolean beep;


    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    public class TimePrinter implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            Date now = new Date();
            System.out.println(" at the tone ,the thime is "+ now);
            if (beep) { // 内部类既可以访问自身的数据域，也可以访问创建他的外围对象的数据域
                // 内部类的对象总是有一个隐式引用
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
