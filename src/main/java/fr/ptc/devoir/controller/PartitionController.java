/**
 * 
 */
package fr.ptc.devoir.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.ptc.devoir.exception.PartitionErrorCode;
import fr.ptc.devoir.exception.PartitionException;

/**
 * @author Sochfy  
 * Service  « partition » qui prend un paramètre 
 * « liste » et un paramètre « taille » et retourne une liste de sous liste,
 * où chaque sous liste a au maximum « taille » éléments.
 *
 */
public class PartitionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PartitionController.class);

	/**
	 * Retourne la liste de sous liste
	 * 
	 * @param <T>
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/partition", method = RequestMethod.GET)
	public <T> List<List<T>> getPartitionBySize(List<T> elements, int sublistsSize)throws PartitionException {
			LOGGER.debug("getPartitionBySize: Début de Fontion de partition");
			 controlInput(sublistsSize, elements);
			List<List<T>> splitedList = partitionedList(elements, sublistsSize);
			LOGGER.debug("getPartitionBySize: Fin de Fontion de partition");

			return splitedList;
		
	}

	private <T> void controlInput(int sublistsSize, List<T> elements) throws PartitionException{
		if (sublistsSize == 0) {
			throw new PartitionException("Erreur fonctionnelle : "+PartitionErrorCode.SIZE_UNSUPPORTED.message(), PartitionErrorCode.SIZE_UNSUPPORTED.statusCode());
		}
		if (CollectionUtils.isEmpty(elements)) {
			throw new PartitionException("Erreur fonctionnelle : "+PartitionErrorCode.EMPTY_ELEMENT.message(), PartitionErrorCode.EMPTY_ELEMENT.statusCode());
		}
	}

	/**
	 * Cette méthode peut être implementer dans une couche Service
	 * @param <T>
	 * @param elements
	 * @param sublistsSize
	 * @param splitedList
	 */
	private <T> List<List<T>> partitionedList(List<T> elements, int sublistsSize) {

		List<List<T>> splitedList = new ArrayList<List<T>>();
		if (sublistsSize >= elements.size()) {
			splitedList.add(elements);
		} else {
			int nbrPartition = elements.size() / sublistsSize;
			if (elements.size() % sublistsSize != 0) {
				nbrPartition++;
			}
			int indexElements = 0;
			for (int i = 0; i < nbrPartition; i++) {
				List<T> subList = new ArrayList<T>();
				while (subList.size() < sublistsSize && indexElements < elements.size()) {
					subList.add(elements.get(indexElements));
					indexElements++;
				}
				splitedList.add(subList);
			}
		}
		return splitedList;
	}

}
