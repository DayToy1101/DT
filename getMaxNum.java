public static StringBuffer getMaxNum(String str1)
    {
        int maxLength=0;
        StringBuffer maxNumBuffer=null;
        int nowLength=0;
        StringBuffer nowNumBuffer=null;
        for(int i=0;i<str1.length();i++)
        {
            //判断该字符是不是数字
            if(str1.charAt(i)>=48 && str1.charAt(i)<=57)
            {
                //处理第一个数字字符的时候，用append(c)会报空指针异常
                if(nowLength==0)
                {
                    nowNumBuffer=new StringBuffer(String.valueOf(str1.charAt(i)));
                    nowLength++;
                }
                else
                {
                    nowNumBuffer.append(str1.charAt(i));
                    nowLength++;
                    if(nowLength>=maxLength)
                    {
                        maxLength=nowLength;
                        maxNumBuffer=nowNumBuffer;
                    }
                }
            }else
            {
                //用于连续数字之后非数字，清楚当前的nowNumBuffer
                nowLength=0;
                nowNumBuffer=null;
            }
        }
        return maxNumBuffer;
    }