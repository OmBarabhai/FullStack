
interface IButton{
  void press();
}
interface ITextbox{
  void setText();
}

class MacButton implements IButton{
  @Override
  public void press(){
    System.out.println("Mac Button Pressed");
  }
}

class WinButton implements IButton{
  @Override
  public void press(){
    System.out.println("Win Button Pressed");
  }
}

class MacTextBox implements ITextbox{
  @Override
  public void setText(){
    System.out.println("Setting text in Mac Textbox");
  }
}

class WinTextBox implements ITextbox{
  @Override
  public void setText(){
    System.out.println("Setting text in Win Textbox");
  }
}