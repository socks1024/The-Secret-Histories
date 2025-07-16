package TheSecretHistories.Content.Events;

import TheSecretHistories.Content.Events.Template.TemplatePhasedEvent;
import TheSecretHistories.Content.Relics.TemporaryHeadquarters;
import TheSecretHistories.Utils.StringUtils;
import basemod.abstracts.events.phases.TextPhase;

public class BookShop extends TemplatePhasedEvent {

    public static final String ID = StringUtils.MakeID(BookShop.class.getSimpleName());
    private static final String IMG_NAME = "TemporaryHeadquarters";

    private enum EventPhase {
        BOOKSHOP,
    }

    public BookShop() {
        super(ID, IMG_NAME);

        registerPhase(EventPhase.BOOKSHOP, new TextPhase(descriptions[0])
                .addOption(options[0], (i) -> SpawnRelicAndObtain(TemporaryHeadquarters.ID))
                .addOption(options[1], (i) -> openMap())
        );

        transitionKey(EventPhase.BOOKSHOP);
    }
}
