package com.goodlaike.henghua.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.goodlaike.framework.dao.support.BaseRWDao;

/**
 * 本地读写 dao
 * 
 * @author jail
 */
public abstract class LocalRWDao<T> extends BaseRWDao<T> {

    @Resource(name = "goodlaikeHenghuaSqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
    
    /**
     * 数据库批量操作
     * 
     * @param interval 分批执行区间
     * @param dataList 数据对象
     * @param operation 具体执行的实现类
     * @return 影响行数
     * @summary 数据库批量操作
     * @author Jail Hu
     * @version v1
     * @since 2016年2月20日
     */
    protected int batchOperate(int interval, List<?> dataList, IBatchOperation operation) {
      if (interval < 0) {
        throw new IllegalArgumentException(String.format("分批执行区间值【%d】不能小于0", interval));
      }
      int fromIndex = 0;
      int toIndex = 0;
      int count = 0;
      if (dataList.size() > 0) {
        List<?> subList;
        while ((toIndex = fromIndex + interval) < dataList.size()) {
          subList = dataList.subList(fromIndex, toIndex);
          count += operation.process(subList);
          fromIndex = toIndex;
        }
        subList = dataList.subList(fromIndex, dataList.size());
        count += operation.process(subList);
      }
      return count;
    }

    interface IBatchOperation {
      int process(List<?> dataList);
    }

    public abstract class BatchOperation implements IBatchOperation {

      SqlSession sqlSession;

      public abstract int process(List<?> dataList);

      /**
       * 
       */
      public BatchOperation(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
      }
      
      public BatchOperation() {
      }

      public SqlSession getSqlSession() {
        return this.sqlSession;
      }
    }
}
