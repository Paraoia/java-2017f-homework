

public class Position {

    private int positionNumber;
    private Huluwa people;
    private boolean empty;

    public Position(int number){
        positionNumber = number;
        empty = true;
    }

    public Huluwa GetPeople(){
        return people;
    }
    public void SetPeople(Huluwa newPeople)
    {
        people = newPeople;
        empty = false;
    }

    public boolean isEmpty()
    {
        return empty;
    }

    public boolean CompareWithValue(Position anotherPos,int type)
    {
        //和另一个位置上的人比较相应的值
        if(this.GetPeopleValue(type) > anotherPos.GetPeopleValue(type))
            return true;
        return false;
    }


    public int GetPeopleValue(int type)
    {
        return people.GetValue(type);

    }

    public int GetPositionNumber(){
        return positionNumber;
    }


    public void LetPeopleJumpToAnotherPos(Position anotherPos)
    {
        //让该位置上的人跳到另一个位置上
        people.talkWhenSwap(this.GetPositionNumber(),anotherPos.GetPositionNumber());

    }

    public void LetPeopleSwapWithAnotherPos(Position anotherPos)
    {
        //让该位置上的人与另一个位置上的人交换
        LetPeopleJumpToAnotherPos(anotherPos);
        anotherPos.LetPeopleJumpToAnotherPos(this);

        Huluwa temp = this.GetPeople();
        this.SetPeople(anotherPos.GetPeople());
        anotherPos.SetPeople(temp);
    }

    public void LetPeopleCountOff(int type)
    {
        //让位置上的人报数
        people.countOff(type);
    }

    public void LetPeopleLeave()
    {
        //让该位置上的人离开
        empty = true;
        people = null;

    }
}
