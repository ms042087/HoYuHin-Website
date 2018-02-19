## Deepcopy
[Download](Deepcopy.py)

    # -*- coding: utf-8 -*-
    """
    Created on Sun Feb 18 12:53:11 2018

    @author: Ho Yu Hin
    """

    import copy
    a=[1,[9,9],3]
    b=a
    print(id(a))
    print(id(b))
    print(id(a)==id(b))

    c=copy.copy(a)
    print(id(a)==id(c))
    print(id(a[1])==id(c[1]))
    c[0]=0
    print(a)
    print(c)

    d=copy.deepcopy(a)
    print(id(a)==id(d))
    print(id(a[1])==id(d[1]))

    d[0]=0
    print(a)
    print(d)
