# dual-numbers
双対数の Scala 版実装です。

## 双対数とは
双対数（二重数とも呼ぶ、下記は二重数と表記）とは、実数の全体に実数ではない新しい元 ε で複零性 ε^2 = 0 を満たすものを添加して得られる実数の拡張概念のこと。具体的には、任意の実数 a, b を用いて下記のように表すことができる数のことをいう。

![a + b \varepsilon](https://latex.codecogs.com/gif.latex?a&space;&plus;&space;b&space;\varepsilon)

https://ja.wikipedia.org/wiki/%E4%BA%8C%E9%87%8D%E6%95%B0

## このサンプルでやっていること
二重数を使用して、関数の微分を自動的に計算することを試みています。たとえば、次のような関数があったとして、

![f(x) = 4x^{3}+3x^{2}+2x+1](https://latex.codecogs.com/gif.latex?f(x)&space;=&space;4x^{3}&plus;3x^{2}&plus;2x&plus;1)

この二重数 z を求めると、

![z = 10+20\varepsilon](https://latex.codecogs.com/gif.latex?z&space;=&space;10&plus;20\varepsilon)

という数が導き出されます。したがって、微分した結果は20であることがわかります。
