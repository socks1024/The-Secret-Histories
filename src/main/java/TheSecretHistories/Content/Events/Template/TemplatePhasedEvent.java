package TheSecretHistories.Content.Events.Template;

import TheSecretHistories.Content.Relics.TemporaryHeadquarters;
import basemod.abstracts.events.PhasedEvent;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.localization.EventStrings;

public abstract class TemplatePhasedEvent extends PhasedEvent {

    private static String MakeImgUrl(String imgName) {
        return "TheSecretHistories/img/events/" + imgName + ".png"; // 600*600
    }

    protected final EventStrings eventStrings;
    protected final String[] descriptions;
    protected final String[] options;

    public TemplatePhasedEvent(String id, String imgUrl) {
        this(id, CardCrawlGame.languagePack.getEventString(id), imgUrl);
    }

    public TemplatePhasedEvent(String id, EventStrings eventStrings, String imgUrl) {
        super(id, eventStrings.NAME, imgUrl);

        this.eventStrings = eventStrings;
        this.descriptions = eventStrings.DESCRIPTIONS;
        this.options = eventStrings.OPTIONS;
    }

    protected void SpawnRelicAndObtain(String relicID) {
        AbstractDungeon.getCurrRoom().spawnRelicAndObtain((float) Settings.WIDTH / 2, (float) Settings.HEIGHT / 2, RelicLibrary.getRelic(relicID).makeCopy());
    }
}
