package com.penglecode.gulubala.dao.music.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.MusicList;
import com.penglecode.gulubala.common.mybatis.EscapeFilter;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.music.MusicListDAO;

@Repository("musicListDAO")
public class MusicListDAOImpl extends BaseMybatisDAO implements MusicListDAO {

	public void insertMusicList(MusicList musicList) {
		getSqlSessionTemplate().insert(getMapperKey("insertMusicList"), musicList);
	}

	public void incrMusicListComments(Long listId) {
		getSqlSessionTemplate().update(getMapperKey("incrMusicListComments"), listId);
	}

	public void incrMusicListPlays(Long listId) {
		getSqlSessionTemplate().update(getMapperKey("incrMusicListPlays"), listId);
	}

	public void incrMusicListPraises(Long listId) {
		getSqlSessionTemplate().update(getMapperKey("incrMusicListPraises"), listId);
	}

	public void incrMusicListCollects(Long listId) {
		getSqlSessionTemplate().update(getMapperKey("incrMusicListCollects"), listId);
	}

	public MusicList getMusicListById(Long listId) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getMusicListById"), listId, new MusicListEscapeFilter());
	}

	public List<MusicList> getMusicLists(Map<String, Object> paramMap, Pager pager) {
		return getSqlSessionTemplate().selectList(getMapperKey("getMusicLists"), paramMap, new MusicListEscapeFilter(), pager);
	}

	protected Class<?> getBoundModelClass() {
		return MusicList.class;
	}

	public static class MusicListEscapeFilter implements EscapeFilter<MusicList> {

		public void doEscapeFilter(MusicList element) {
			if(!StringUtils.isEmpty(element.getMusicIds())){
				element.setMusicCount(element.getMusicIds().split(",").length);
			}
		}
		
	}
	
}
