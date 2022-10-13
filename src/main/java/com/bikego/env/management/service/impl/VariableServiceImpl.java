package com.bikego.env.management.service.impl;

import com.bikego.env.management.domain.VariableEntity;
import com.bikego.env.management.domain.VariableRenderLogEntity;
import com.bikego.env.management.repository.VariableRenderLogRepository;
import com.bikego.env.management.repository.VariableRepository;
import com.bikego.env.management.service.VariableService;
import com.bikego.env.management.service.dto.VariableDto;
import com.bikego.env.management.service.mapstruct.VariableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.swing.text.html.HTMLDocument;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class VariableServiceImpl implements VariableService {

    @Autowired
    private VariableRepository variableRepository;

    @Autowired
    private VariableRenderLogRepository variableRenderLogRepository;

    @Autowired
    private VariableMapper variableMapper;


    public Page<VariableEntity> getPageVariable(String name, String env,int pageNo, int pageSize, Sort.Direction dir, String str) {

        //创建分页对象
        PageRequest request = buildPageRequest(pageNo, pageSize, dir, str);

        return variableRepository.findAll(new Specification<VariableEntity> () {

            public Predicate toPredicate(Root<VariableEntity> root,CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<Predicate>();

                //链接
//                Join<VariableEntity, VariableRenderLogEntity> variableRenderLogEntityJoin = root.join("variable_render_log", JoinType.LEFT);

                // 变量名称，模糊查询
                if (name != null && !"".equals(name)) {
                    predicates.add(criteriaBuilder.like(root.get("name"), "%" + name+ "%"));
                }

                //env，相等查询
                if (env != null && !"".equals(env)) {
                    predicates.add(criteriaBuilder.equal(root.get("env"), env));
                }

                criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

                return null;
            }
        }
        , request);

    }

    /**
     * 构建PageRequest对象
     * @param num	当前页码
     * @param size	每页条数
     * @param asc	排序方式：Sort.Direction.ASC 升序，Sort.Direction.DESC 倒序
     * @param string 排序字段：一般为主键id
     */
    private PageRequest buildPageRequest(int num, int size, Sort.Direction asc,String string) {
        return PageRequest.of(num-1, size,asc,string);
    }

    @Override
    public Page<VariableEntity> listPage(Pageable pageable, List<String> nameList, String env)
    {

        Page<VariableEntity> variableEntityPage = this.variableRepository.listPage(nameList,env,pageable);

        return variableEntityPage;
    }

    /**
     * 搜索环境变量
     * @param name
     * @param env
     * @return
     */
    @Override
    public List<VariableEntity> getVariable(String name, String env)
    {

        List<VariableEntity> variableEntityList = this.variableRepository.getVariable(name,env);

        return variableEntityList;
    }

    @Override
    public List<VariableEntity> list(List<String> nameList,String env,String project) {

        List<VariableEntity> variableEntityList = this.variableRepository.list(nameList,env);

        List<VariableRenderLogEntity> variableRenderLogList = new ArrayList<>();

        for( VariableEntity item : variableEntityList)
        {
            //该变量发布次数加1
            item.setRenderNum(item.getRenderNum() + 1 );
            //变量记录发布日志
            VariableRenderLogEntity variableRenderLog = new VariableRenderLogEntity();
            variableRenderLog.setVariableId(item.getId());
            variableRenderLog.setProject(project);
            Timestamp currentTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
            variableRenderLog.setCreatedAt(currentTime);

            variableRenderLogRepository.saveAndFlush(variableRenderLog);
        }

        //保存发布次数
        variableRepository.saveAll(variableEntityList);

//        List<VariableDto> variableDtoList = this.variableMapper.toDto(variableEntityList);

        return variableEntityList;
    }

    @Override
    @Transactional
    public boolean add(VariableDto variableDto) {
        VariableEntity variableEntity = this.variableMapper.toEntity(variableDto);
        variableEntity = this.variableRepository.saveAndFlush(variableEntity);
        return true;
    }

    @Override
    @Transactional
    public VariableDto info(Integer id) {
        VariableEntity variableEntity = this.variableRepository.info(id);
        VariableDto variableDto = variableMapper.toDto(variableEntity);
        return variableDto;
    }


    @Override
    public boolean addAll(List<VariableDto> variableDtoList) {

        List<VariableEntity> variableEntityList = this.variableMapper.toEntity(variableDtoList);
        variableEntityList = this.variableRepository.saveAll(variableEntityList);
        return true;
    }
}
