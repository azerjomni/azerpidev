<?php

/*
 * This file is part of the Sonata Project package.
 *
 * (c) Thomas Rabaix <thomas.rabaix@sonata-project.org>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

namespace Sonata\CoreBundle\Form\Type;

if (!class_exists(\Sonata\Form\Type\CollectionType::class, false)) {
    @trigger_error(
        'The '.__NAMESPACE__.'\CollectionType class is deprecated since version 3.x and will be removed in 4.0.'
        .' Use Sonata\Form\Type\CollectionType instead.',
        E_USER_DEPRECATED
    );
}

/**
 * @deprecated Since version 3.x, to be removed in 4.0.
 */
class CollectionType extends \Sonata\Form\Type\CollectionType
{
    public function getName()
    {
        return 'sonata_type_collection_legacy';
    }
}
