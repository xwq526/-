package org.example.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xuwenqing
 * Date: 2020-12-03
 * Time: 20:28:02
 */
public class DBUtilTest {

    @Test
    public void testConnection(){
        Assert.assertNotNull(DButil.getConnection());
    }
}
