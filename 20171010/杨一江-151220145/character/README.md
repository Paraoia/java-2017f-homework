#Description of package _character_

!!! THIS FILE IS OUT-OF-DATE !!!

```This manual will describe the brief Information of this 
package for the quick check. Directory Structure is as followed:

    character
        ├ Beings
        └ hero
            └ Huluwa

##Inherent Structure

    Beings
    └ Huluwa

Class _Beings_ is the base class of package _character_,
Containing the protected field _where_, _coord_ and 
_dimension_ and corresponding methods. In particular, 
the following methods are _final_ methods:

    final public BasePosition TellBasePosition();
    final public void JumpTO(BasePosition toBasePosition);
    final public BasePosition JumpOut();

In _hero_ directory, _Huluwa_ is the base class, inherited
from _Beings_ as well as a debug platform, which means we can debug _Huluwa_ in the method

    static public void main(String[] argv);

However, the only field of it is 

    static int TotalBrother = 0;
    
