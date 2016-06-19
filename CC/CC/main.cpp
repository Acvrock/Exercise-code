//
//  main.cpp
//  CC
//
//  Created by moon on 16/6/10.
//  Copyright © 2016年 moon. All rights reserved.
//

#include <iostream>

int main(int argc, const char * argv[]) {

 
    
    for(int i=100;i<999;i++){
        int ge = i%10;
        int shi = (i%100)/10;
        int bai = i/100;
        if(ge*ge*ge+shi*shi*shi+bai*bai*bai  == i){
            std::cout << i;
            std::cout << "\n";
        }
    }
    
    return 0;
}
