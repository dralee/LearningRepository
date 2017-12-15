// StudentQuery.aidl
package com.lee.jackie.remoteservice.services;

// Declare any non-default types here with import statements

// 注意没有任何访问权限修饰符
interface StudentQuery {
    // 通过number来访问学生的name
    String queryStudent(int number);
}

