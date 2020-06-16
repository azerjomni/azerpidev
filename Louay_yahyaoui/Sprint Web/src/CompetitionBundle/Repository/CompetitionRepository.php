<?php

namespace CompetitionBundle\Repository;

/**
 * CompetitionRepository
 *
 * This class was generated by the Doctrine ORM. Add your own custom
 * repository methods below.
 */
class CompetitionRepository extends \Doctrine\ORM\EntityRepository
{

    public function findComp($id)
    {
        $query=$this->getEntityManager()->createQuery(
            'SELECT p 
            FROM CompetitionBundle:Participation p
            WHERE p.idcompetition = :p_id'

        )
            ->setParameter('p_id', "%" . $id . "%" );
        return $query->getResult();
    }

    public function findEntitiesByString($str)
    {


        return $this->getEntityManager()->createQuery(
            'SELECT p 
            FROM CompetitionBundle:Competition p
            WHERE p.titre LIKE :str
        ORDER BY p.titre ASC'
        )
            ->setParameter('str','%'.$str.'%')
            ->getResult();
    }






}