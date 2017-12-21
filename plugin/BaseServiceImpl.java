import com.ycgwl.framework.exception.BusinessException;
import com.ycgwl.framework.springmvc.service.IBaseService;
import org.mybatis.spring.dao.IBaseDao;
import org.mybatis.spring.support.Page;
import org.mybatis.spring.support.Pagination;
import org.mybatis.spring.support.Sort;

import java.util.List;
import java.util.Map;

/**
 *
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T,String> {

	abstract IBaseDao<T, String> getBaseDao();

	@Override
	public int insert(T t) throws BusinessException {
		return this.getBaseDao().insert(t);
	}

	@Override
	public int update(T t) throws BusinessException {
		return this.getBaseDao().update(t);
	}

	@Override
	public T getById(String s) throws BusinessException {
		return this.getBaseDao().getById(s);
	}

	@Override
	public List<T> get(Map<String, Object> map) throws BusinessException {
		return this.getBaseDao().get(map);
	}

	/**
	 * 实际执行的aop 分页拦截是用的 mysql的方言
	 * @param map
	 * @param i
	 * @param i1
	 * @return
	 * @throws BusinessException
	 */
	@Deprecated
	@Override
	public List<T> getPage(Map<String, Object> map, int i, int i1) throws BusinessException {
		return this.getBaseDao().getPage(map,i,i1);
	}

	/**
	 *
	 * @param map 不能为空
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public int getPageTotalCount(Map<String, Object> map) throws BusinessException {
		return this.getBaseDao().getPageTotalCount(map);
	}

	@Override
	public int deleteById(String s) throws BusinessException {
		return this.getBaseDao().deleteById(s);
	}

	@Deprecated
	@Override
	public int updateStatusById(String s, int i) throws BusinessException {
		return this.getBaseDao().updateStatusById(s,i);
	}

	/**
	 * @param map map不能为空
	 * @param page
	 * @param sorts
	 * @return
	 * @throws BusinessException
	 */
	@Deprecated
	@Override
	public Pagination<T> getPagination(Map<String, Object> map, Page page, Sort... sorts) throws BusinessException {
		return this.getBaseDao().getPagination(map,page,sorts);
	}
}
