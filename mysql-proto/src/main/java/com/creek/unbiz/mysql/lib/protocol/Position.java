package com.creek.unbiz.mysql.lib.protocol;

/**
 * Created by 成国栋 on 2017-04-18 00:30:00.
 */
public class Position {
  private int pos;

  public Position(int pos) {
    this.pos = pos;
  }

  public static Position factory() {
    return new Position(0);
  }

  public static Position factory(int pos) {
    return new Position(pos);
  }

  public void reset() {
    this.pos = 0;
  }

  public int forwardPos() {
    return ++pos;
  }

  public void forward2Pos(int to) {
    pos = to;
  }

  public int forwardPos(int step) {
    pos += step;
    return pos;
  }

  public int getAndForwardPos() {
    return pos++;
  }

  public int getPos() {
    return pos;
  }
}
