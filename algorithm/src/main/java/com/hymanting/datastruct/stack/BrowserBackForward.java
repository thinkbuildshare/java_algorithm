package com.hymanting.datastruct.stack;

import java.util.Stack;

/**
 * @Author hxchen
 * @Date 2021/3/7
 */
public class BrowserBackForward {
    static Stack<String> urlStack = new Stack<>();

    //记录栈指针，有些场景不真正移除元素, 0表示不指向任何元素，1指向第一个元素
    static int currentIndex = 0;

    public static void main(String[] args) throws InterruptedException {
        selfTryImplement();
    }

    /**
     * 自己尝试实现一下
     */
    private static void selfTryImplement() throws InterruptedException {
        //访问一个url
        System.out.println("-------------访问新url------------");
        visitNewUrl();
        System.out.println("-------------访问新url------------");
        visitNewUrl();
        System.out.println("-------------前进------------");
        forward();
        System.out.println("-------------后退------------");
        back();
        System.out.println("-------------后退------------");
        back();
        System.out.println("-------------前进------------");
        forward();
        System.out.println("-------------访问新url------------");
        visitNewUrl();
        System.out.println("-------------后退------------");
        back();
        System.out.println("-------------访问新url------------");
        visitNewUrl();
        System.out.println("-------------前进------------");
        forward();
        System.out.println("-------------后退------------");
        back();
    }

    private static void back() {
        //不能后退
        if(currentIndex <= 1) {
            System.out.println("已经到头");
        } else {
            currentIndex--;
            System.out.println("当前url：" + urlStack.get(currentIndex - 1));
        }
    }

    private static void forward() {
        //不能前进
        if(currentIndex == urlStack.size()) {
            System.out.println("已经到尾");
        } else {
            currentIndex++;
            System.out.println("当前url:" + urlStack.get(currentIndex - 1));
        }
    }

    private static void visitNewUrl() throws InterruptedException {
        String url = generateUrl();
        //指针落后于栈顶元素。说明当前url属于中间url，能前进能后退，此时访问新url，则移除栈顶元素，压入新url
        while(urlStack.size() > currentIndex) {
            urlStack.pop();
        }
        //新url压栈，成为栈顶
        urlStack.push(url);
        currentIndex++;
        System.out.println("=====当前栈=====");
        urlStack.forEach(s-> {
            System.out.println(s);
        });
        System.out.println("当前指针指向：" + urlStack.get(currentIndex - 1));
    }

    private static String generateUrl() throws InterruptedException {
        Thread.sleep(1);
        return String.valueOf(System.currentTimeMillis());
    }
}