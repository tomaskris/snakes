///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package actions;
//
//import manager.Manager;
//import manager.SnakeManager;
//
///**
// *
// * @author Tomáš
// */
//public class SnakeActionManager {
//
//    private ISnakeAction actionExpand;
//    private ISnakeAction actionNarrow;
//    private ISnakeAction actionSpeedUp;
//    private ISnakeAction actionSpeedDown;
//    
//    public SnakeActionManager() {
//        this.actionExpand = new ExpandBody();
//        this.actionNarrow = new NarrowBody();
//        this.actionSpeedUp = new SpeedUp();
//        this.actionSpeedDown = new SpeedDown();
//    }
//    
//    public void executeEpandingSnake(SnakeManager snake){
//        actionExpand.execute(snake);
//    }
//    
//    public void executeNarrowingSnake(SnakeManager snake){
//        actionNarrow.execute(snake);
//    }
//    
//    public void executeSpeedUpSnake(SnakeManager snake){
//        actionSpeedUp.execute(snake);
//    }
//    
//    public void executeSpeedDownSnake(SnakeManager snake){
//        actionSpeedDown.execute(snake);
//    }
//    
//}
