/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.designer.business.model.business.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.talend.designer.business.model.business.util.BusinessAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The adapters generated by this
 * factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}. The adapters
 * also support Eclipse property sheets. Note that most of the adapters are shared among multiple instances. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class BusinessItemProviderAdapterFactory extends BusinessAdapterFactory implements ComposeableAdapterFactory,
        IChangeNotifier, IDisposable {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = ""; //$NON-NLS-1$

    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Collection supportedTypes = new ArrayList();

    /**
     * This constructs an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public BusinessItemProviderAdapterFactory() {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
        supportedTypes.add(ITableItemLabelProvider.class);
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.Repository} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected RepositoryItemProvider repositoryItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.Repository}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createRepositoryAdapter() {
        if (repositoryItemProvider == null) {
            repositoryItemProvider = new RepositoryItemProvider(this);
        }

        return repositoryItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.BusinessProcess} instances.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected BusinessProcessItemProvider businessProcessItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.BusinessProcess}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createBusinessProcessAdapter() {
        if (businessProcessItemProvider == null) {
            businessProcessItemProvider = new BusinessProcessItemProvider(this);
        }

        return businessProcessItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.Process} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected ProcessItemProvider processItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.Process}.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    public Adapter createProcessAdapter() {
        if (processItemProvider == null) {
            processItemProvider = new ProcessItemProvider(this);
        }

        return processItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.Routine} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected RoutineItemProvider routineItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.Routine}.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    public Adapter createRoutineAdapter() {
        if (routineItemProvider == null) {
            routineItemProvider = new RoutineItemProvider(this);
        }

        return routineItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.Documentation} instances.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected DocumentationItemProvider documentationItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.Documentation}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createDocumentationAdapter() {
        if (documentationItemProvider == null) {
            documentationItemProvider = new DocumentationItemProvider(this);
        }

        return documentationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.DatabaseMetadata} instances.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected DatabaseMetadataItemProvider databaseMetadataItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.DatabaseMetadata}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createDatabaseMetadataAdapter() {
        if (databaseMetadataItemProvider == null) {
            databaseMetadataItemProvider = new DatabaseMetadataItemProvider(this);
        }

        return databaseMetadataItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.TableMetadata} instances.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected TableMetadataItemProvider tableMetadataItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.TableMetadata}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createTableMetadataAdapter() {
        if (tableMetadataItemProvider == null) {
            tableMetadataItemProvider = new TableMetadataItemProvider(this);
        }

        return tableMetadataItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.FileDelimitedMetadata} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FileDelimitedMetadataItemProvider fileDelimitedMetadataItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.FileDelimitedMetadata}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Adapter createFileDelimitedMetadataAdapter() {
        if (fileDelimitedMetadataItemProvider == null) {
            fileDelimitedMetadataItemProvider = new FileDelimitedMetadataItemProvider(this);
        }

        return fileDelimitedMetadataItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.FilePositionalMetadata} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FilePositionalMetadataItemProvider filePositionalMetadataItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.FilePositionalMetadata}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Adapter createFilePositionalMetadataAdapter() {
        if (filePositionalMetadataItemProvider == null) {
            filePositionalMetadataItemProvider = new FilePositionalMetadataItemProvider(this);
        }

        return filePositionalMetadataItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.BusinessAssignment} instances.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected BusinessAssignmentItemProvider businessAssignmentItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.BusinessAssignment}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createBusinessAssignmentAdapter() {
        if (businessAssignmentItemProvider == null) {
            businessAssignmentItemProvider = new BusinessAssignmentItemProvider(this);
        }

        return businessAssignmentItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.BusinessItemRelationship} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BusinessItemRelationshipItemProvider businessItemRelationshipItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.BusinessItemRelationship}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createBusinessItemRelationshipAdapter() {
        if (businessItemRelationshipItemProvider == null) {
            businessItemRelationshipItemProvider = new BusinessItemRelationshipItemProvider(this);
        }

        return businessItemRelationshipItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.DecisionBusinessItem} instances.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected DecisionBusinessItemItemProvider decisionBusinessItemItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.DecisionBusinessItem}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createDecisionBusinessItemAdapter() {
        if (decisionBusinessItemItemProvider == null) {
            decisionBusinessItemItemProvider = new DecisionBusinessItemItemProvider(this);
        }

        return decisionBusinessItemItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.ActionBusinessItem} instances.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected ActionBusinessItemItemProvider actionBusinessItemItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.ActionBusinessItem}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createActionBusinessItemAdapter() {
        if (actionBusinessItemItemProvider == null) {
            actionBusinessItemItemProvider = new ActionBusinessItemItemProvider(this);
        }

        return actionBusinessItemItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.TerminalBusinessItem} instances.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected TerminalBusinessItemItemProvider terminalBusinessItemItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.TerminalBusinessItem}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createTerminalBusinessItemAdapter() {
        if (terminalBusinessItemItemProvider == null) {
            terminalBusinessItemItemProvider = new TerminalBusinessItemItemProvider(this);
        }

        return terminalBusinessItemItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.DataBusinessItem} instances.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected DataBusinessItemItemProvider dataBusinessItemItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.DataBusinessItem}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createDataBusinessItemAdapter() {
        if (dataBusinessItemItemProvider == null) {
            dataBusinessItemItemProvider = new DataBusinessItemItemProvider(this);
        }

        return dataBusinessItemItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.DocumentBusinessItem} instances.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected DocumentBusinessItemItemProvider documentBusinessItemItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.DocumentBusinessItem}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createDocumentBusinessItemAdapter() {
        if (documentBusinessItemItemProvider == null) {
            documentBusinessItemItemProvider = new DocumentBusinessItemItemProvider(this);
        }

        return documentBusinessItemItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.InputBusinessItem} instances.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected InputBusinessItemItemProvider inputBusinessItemItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.InputBusinessItem}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createInputBusinessItemAdapter() {
        if (inputBusinessItemItemProvider == null) {
            inputBusinessItemItemProvider = new InputBusinessItemItemProvider(this);
        }

        return inputBusinessItemItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.ListBusinessItem} instances.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected ListBusinessItemItemProvider listBusinessItemItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.ListBusinessItem}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createListBusinessItemAdapter() {
        if (listBusinessItemItemProvider == null) {
            listBusinessItemItemProvider = new ListBusinessItemItemProvider(this);
        }

        return listBusinessItemItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.DatabaseBusinessItem} instances.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected DatabaseBusinessItemItemProvider databaseBusinessItemItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.DatabaseBusinessItem}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createDatabaseBusinessItemAdapter() {
        if (databaseBusinessItemItemProvider == null) {
            databaseBusinessItemItemProvider = new DatabaseBusinessItemItemProvider(this);
        }

        return databaseBusinessItemItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.FileRegexpMetadata} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FileRegexpMetadataItemProvider fileRegexpMetadataItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.FileRegexpMetadata}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Adapter createFileRegexpMetadataAdapter() {
        if (fileRegexpMetadataItemProvider == null) {
            fileRegexpMetadataItemProvider = new FileRegexpMetadataItemProvider(this);
        }

        return fileRegexpMetadataItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.ActorBusinessItem} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ActorBusinessItemItemProvider actorBusinessItemItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.ActorBusinessItem}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Adapter createActorBusinessItemAdapter() {
        if (actorBusinessItemItemProvider == null) {
            actorBusinessItemItemProvider = new ActorBusinessItemItemProvider(this);
        }

        return actorBusinessItemItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.EllipseBusinessItem} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EllipseBusinessItemItemProvider ellipseBusinessItemItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.EllipseBusinessItem}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Adapter createEllipseBusinessItemAdapter() {
        if (ellipseBusinessItemItemProvider == null) {
            ellipseBusinessItemItemProvider = new EllipseBusinessItemItemProvider(this);
        }

        return ellipseBusinessItemItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.GearBusinessItem} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GearBusinessItemItemProvider gearBusinessItemItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.GearBusinessItem}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Adapter createGearBusinessItemAdapter() {
        if (gearBusinessItemItemProvider == null) {
            gearBusinessItemItemProvider = new GearBusinessItemItemProvider(this);
        }

        return gearBusinessItemItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.FileXmlMetadata} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FileXmlMetadataItemProvider fileXmlMetadataItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.FileXmlMetadata}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Adapter createFileXmlMetadataAdapter() {
        if (fileXmlMetadataItemProvider == null) {
            fileXmlMetadataItemProvider = new FileXmlMetadataItemProvider(this);
        }

        return fileXmlMetadataItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.talend.designer.business.model.business.FileLdifMetadata} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FileLdifMetadataItemProvider fileLdifMetadataItemProvider;

    /**
     * This creates an adapter for a {@link org.talend.designer.business.model.business.FileLdifMetadata}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Adapter createFileLdifMetadataAdapter() {
        if (fileLdifMetadataItemProvider == null) {
            fileLdifMetadataItemProvider = new FileLdifMetadataItemProvider(this);
        }

        return fileLdifMetadataItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean isFactoryForType(Object type) {
        return supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public Adapter adapt(Notifier notifier, Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Object adapt(Object object, Object type) {
        if (isFactoryForType(type)) {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class) || (((Class)type).isInstance(adapter))) {
                return adapter;
            }
        }

        return null;
    }

    /**
     * This adds a listener.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void addListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void removeListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public void fireNotifyChanged(Notification notification) {
        changeNotifier.fireNotifyChanged(notification);

        if (parentAdapterFactory != null) {
            parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. 
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void dispose() {
        if (repositoryItemProvider != null) repositoryItemProvider.dispose();
        if (businessProcessItemProvider != null) businessProcessItemProvider.dispose();
        if (processItemProvider != null) processItemProvider.dispose();
        if (routineItemProvider != null) routineItemProvider.dispose();
        if (documentationItemProvider != null) documentationItemProvider.dispose();
        if (databaseMetadataItemProvider != null) databaseMetadataItemProvider.dispose();
        if (tableMetadataItemProvider != null) tableMetadataItemProvider.dispose();
        if (fileDelimitedMetadataItemProvider != null) fileDelimitedMetadataItemProvider.dispose();
        if (filePositionalMetadataItemProvider != null) filePositionalMetadataItemProvider.dispose();
        if (businessAssignmentItemProvider != null) businessAssignmentItemProvider.dispose();
        if (businessItemRelationshipItemProvider != null) businessItemRelationshipItemProvider.dispose();
        if (decisionBusinessItemItemProvider != null) decisionBusinessItemItemProvider.dispose();
        if (actionBusinessItemItemProvider != null) actionBusinessItemItemProvider.dispose();
        if (terminalBusinessItemItemProvider != null) terminalBusinessItemItemProvider.dispose();
        if (dataBusinessItemItemProvider != null) dataBusinessItemItemProvider.dispose();
        if (documentBusinessItemItemProvider != null) documentBusinessItemItemProvider.dispose();
        if (inputBusinessItemItemProvider != null) inputBusinessItemItemProvider.dispose();
        if (listBusinessItemItemProvider != null) listBusinessItemItemProvider.dispose();
        if (databaseBusinessItemItemProvider != null) databaseBusinessItemItemProvider.dispose();
        if (fileRegexpMetadataItemProvider != null) fileRegexpMetadataItemProvider.dispose();
        if (actorBusinessItemItemProvider != null) actorBusinessItemItemProvider.dispose();
        if (ellipseBusinessItemItemProvider != null) ellipseBusinessItemItemProvider.dispose();
        if (gearBusinessItemItemProvider != null) gearBusinessItemItemProvider.dispose();
        if (fileXmlMetadataItemProvider != null) fileXmlMetadataItemProvider.dispose();
        if (fileLdifMetadataItemProvider != null) fileLdifMetadataItemProvider.dispose();
    }

}
